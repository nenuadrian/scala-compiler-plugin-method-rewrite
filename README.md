# scalac compiler plugin

https://medium.com/@adrian.n/scala-compiler-plugin-annotation-based-method-ast-rewriting-wrapping-substitution-b802f2d922f1

A small example of a scala compiler plugin with basic annotation parsing, AST traversal and DefDef method body replacement by subsituting the block with an inner method wrapping the original code + extra behaviour.


Run ./buid.sh and cd test; ./build.sh to see the output of the attached compiler plugin.


Excute cd test; ./run.sh to see the outputs of the replaced method. Still returns the same value but it's behaviour can be enhanced, eg sent for execution remotely.
