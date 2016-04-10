{\rtf1\ansi\ansicpg1252\cocoartf1348\cocoasubrtf170
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
## Dependencies\
\
- [Java SE 7](http://www.oracle.com/technetwork/java/javase/downloads/) (JDK 1.7) as your `$JAVA_HOME`.\
- [Maven](https://maven.apache.org/) in your `$PATH`.\
- [gettext](https://www.gnu.org/software/gettext/) in your `$PATH`.\
- (optional) [Eclipse](https://eclipse.org/)\
\
\
## Package the latest version of the `master` branch.\
\
\
```bash\
cd your-development-folder    # Your own preference.\
                              # Get farin's fork of WebSockets.\
git clone https://github.com/farin/Java-WebSocket.git\
cd Java-WebSocket\
mvn install                   # Install the WebSockets fork version.\
cd - >/dev/null\
\
                              # Get JCloisterZone.\
git clone https://github.com/farin/JCloisterZone.git\
cd JCloisterZone\
mvn package                   # Create the main and plugin jar files.\
\
open build/JCloisterZone.jar  # Execute the game.\
```}