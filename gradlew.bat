@echo off
set DIR=%~dp0
set APP_HOME=%DIR%
set DEFAULT_JVM_OPTS=
"%JAVA_HOME%\bin\java.exe" %DEFAULT_JVM_OPTS% -classpath "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
