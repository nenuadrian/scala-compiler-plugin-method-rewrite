scalac -language:postfixOps -feature -d out src/*.scala

cp src/scalac-plugin.xml out

(cd out; jar cf ../release.jar .)
