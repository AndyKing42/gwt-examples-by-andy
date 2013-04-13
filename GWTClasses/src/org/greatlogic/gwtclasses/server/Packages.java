package org.greatlogic.gwtclasses.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.greatlogic.gwtclasses.server.IServerEnums.EConfigAD;
import com.google.common.collect.Maps;
import com.greatlogic.glbase.gllib.GLConfig;
import com.greatlogic.glbase.gllib.GLLog;
/**
 * This singleton class loads the packages from the GWT packages summary HTML file. The package
 * entries are formatted like this:
 * <tr class="altColor">
 * <td class="colFirst"><a href="com/google/gwt/activity/shared/package-summary.html">com.google.gwt.activity.shared</a></td>
 * <td class="colLast">
 * <div class="block">Classes used to implement app navigation.</div>
 * </td>
 * </tr>
 * <tr class="rowColor">
 * <td class="colFirst"><a href="com/google/gwt/animation/client/package-summary.html">com.google.gwt.animation.client</a></td>
 * <td class="colLast">
 * <div class="block">Classes for Animation support.</div>
 * </td>
 * </tr>
 */
class Packages {
//--------------------------------------------------------------------------------------------------
private static Object            _lock;
private Map<String, PackageInfo> _packageInfoMap;
private static Packages          _packages;
//--------------------------------------------------------------------------------------------------
static {
  _lock = new Object();
} // static initializer
//--------------------------------------------------------------------------------------------------
static Packages getInstance() {
  synchronized (_lock) {
    if (_packages == null) {
      _packages = new Packages();
    }
  }
  return _packages;
} // getInstance()
//--------------------------------------------------------------------------------------------------
boolean load(final ZipFile zipFile) {
  boolean result;
  _packageInfoMap = Maps.newTreeMap(String.CASE_INSENSITIVE_ORDER);
  final String packagesHTMLFilename = GLConfig.getTopConfigElement().attributeAsString(EConfigAD.PackagesHTMLFilename);
  final ZipEntry zipEntry = zipFile.getEntry(packagesHTMLFilename);
  if (zipEntry == null) {
    GLLog.major("Packages HTML file not found in archive:" + packagesHTMLFilename);
    return false;
  }
  result = loadPackageInfo(zipFile, zipEntry);
  for (final PackageInfo packageInfo : _packageInfoMap.values()) {
    GLLog.debug(packageInfo.getName() + " -> " + packageInfo.getDesc());
  }
  return result;
} // load()
//--------------------------------------------------------------------------------------------------
private boolean loadPackageInfo(final ZipFile zipFile, final ZipEntry zipEntry) {
  try {
    final InputStream inputStream = zipFile.getInputStream(zipEntry);
    final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    try {
      String line;
      PackageInfo packageInfo = null;
      do {
        line = reader.readLine();
        if (line != null) {
          if (line.contains("class=\"colFirst\"") && line.contains("href")) {
            final int beginIndex = line.indexOf("com.google");
            if (beginIndex > 0) {
              final int endIndex = line.indexOf('<', beginIndex);
              if (endIndex > 0) {
                packageInfo = new PackageInfo(line.substring(beginIndex, endIndex));
                _packageInfoMap.put(packageInfo.getName(), packageInfo);
              }
            }
          }
          else if (line.contains("class=\"block\"") && packageInfo != null) {
            final int beginIndex = line.indexOf('>');
            if (beginIndex > 0) {
              final int endIndex = line.indexOf('<', beginIndex);
              if (endIndex > 0) {
                packageInfo.setDesc(line.substring(beginIndex + 1, endIndex));
              }
            }
            packageInfo = null;
          }
        }
      } while (line != null);
    }
    finally {
      reader.close();
    }
  }
  catch (final Exception e) {
    GLLog.major("Failed to load the packages file:" + zipEntry.getName(), e);
    return false;
  }
  return true;
} // loadPackageInfo()
//--------------------------------------------------------------------------------------------------
}