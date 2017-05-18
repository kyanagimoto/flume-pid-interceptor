# Flume Interceptor: flume-pid-interceptor

This project provides an interceptor for Flume.  
Add flume process ID on event header.

## How to use
1. Clone project
2. Build with Maven
```
cd ./flume-pid-interceptor
mvn clean install
```

3. The jar file will be installed in your local maven repository and can be found in sub-directory.  
Add it on Flume classpath.
```
cp ./target/flume-pid-interceptor-0.X.jar /path/to/flume/dir/lib
```

4. Configure Flume conf file.
Saved values (flumePid) on flume event header.

example)
```properties
agent.sources = r1
agent.sinks = s1

agent.sources.r1.interceptor = i1
agent.sources.r1.interceptors.i1.type = org.kyanagimoto.flume.interceptor.FlumePidInterceptor$Builder

agent.sinks.s1.hdfs.filePrefix = sample-prefix-${flumePid}
```
# Change Log