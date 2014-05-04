package org.greatlogic.runtimecssexample.server;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.greatlogic.glbase.gllib.GLLog;
import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;

@SuppressWarnings("serial")
public class InitServlet extends GenericServlet {
//--------------------------------------------------------------------------------------------------
private static final String ClassHierarchySeparator   = "->";
private static final String OutputLevelAbstractPrefix = "--";
private static final String OutputLevelConcretePrefix = "++";
//==================================================================================================
private static class RCSSEProgram implements IGLProgram {
@Override
public boolean displayCommandLineHelp() {
  return false;
} // displayCommandLineHelp()
} // class RCSSEProgram
//==================================================================================================
private void getClassHierarchy(final ClassLoader classLoader, final Class<?> baseClass) {
  ClassPath classPath;
  try {
    final TreeMap<String, ClassInfo> classHierarchyMap = Maps.newTreeMap();
    final Set<ClassInfo> concreteSet = Sets.newHashSet();
    classPath = ClassPath.from(classLoader);
    final ImmutableSet<ClassInfo> classInfoSet;
    classInfoSet = classPath.getTopLevelClassesRecursive(baseClass.getPackage().getName());
    for (final ClassInfo classInfo : classInfoSet) {
      final Class<?> loadedClass = classInfo.load();
      if (loadedClass == baseClass) {
        classHierarchyMap.put(baseClass.getSimpleName(), classInfo);
      }
      else if (baseClass.isAssignableFrom(loadedClass)) {
        String classHierarchy = "";
        Class<?> parentClass = loadedClass;
        do {
          classHierarchy = parentClass.getSimpleName() +
                           (classHierarchy.isEmpty() ? "" : ClassHierarchySeparator +
                                                            classHierarchy);
          parentClass = parentClass.getSuperclass();
        } while (parentClass != baseClass);
        classHierarchy = baseClass.getSimpleName() + "->" + classHierarchy;
        classHierarchyMap.put(classHierarchy, classInfo);
        final int modifiers = loadedClass.getModifiers();
        if (!Modifier.isAbstract(modifiers) && !Modifier.isInterface(modifiers) &&
            Modifier.isPublic(modifiers)) {
          concreteSet.add(classInfo);
        }
      }
    }
    for (final Entry<String, ClassInfo> classHierarchyMapInfo : classHierarchyMap.entrySet()) {
      final int levels = StringUtils.countMatches(classHierarchyMapInfo.getKey(),
                                                  ClassHierarchySeparator);
      String prefix;
      if (concreteSet.contains(classHierarchyMapInfo.getValue())) {
        prefix = StringUtils.repeat(OutputLevelConcretePrefix, levels);
      }
      else {
        prefix = StringUtils.repeat(OutputLevelAbstractPrefix, levels);
      }
      GLLog.debug(prefix + classHierarchyMapInfo.getValue().getSimpleName());
    }
  }
  catch (final IOException ioe) {
    GLLog.minor("Error using ClassPath", ioe);
  }
}
//--------------------------------------------------------------------------------------------------
@Override
public void init() {
  final String configFilename = "cfg/RCSSE.cfg";
  GLUtil.initializeProgram(new RCSSEProgram(), null, null, false, //
                           "<args ConfigFilename='" + configFilename + "'/>");
  //  getClassHierarchy(UIObject.class.getClassLoader(), UIObject.class);
}
//--------------------------------------------------------------------------------------------------
@Override
public void service(final ServletRequest request, final ServletResponse response)
  throws ServletException, IOException {
  //
}
//--------------------------------------------------------------------------------------------------
}