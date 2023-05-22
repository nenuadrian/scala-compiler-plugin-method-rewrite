# scalac compiler plugin

https://medium.com/@adrian.n/scala-compiler-plugin-annotation-based-method-ast-rewriting-wrapping-substitution-b802f2d922f1

The article showcases a Scala compiler plugin that serves as a small example. It demonstrates basic annotation parsing, AST traversal, and the replacement of a method body (DefDef) by substituting the block with an inner method that wraps the original code and includes additional behavior.

To observe the output of the attached compiler plugin, run the "./build.sh" command, followed by navigating to the "test" directory and executing "./build.sh" there.

To view the outputs of the replaced method, run "./run.sh" within the "test" directory. Although the method still returns the same value, its behavior can be enhanced, such as being sent for remote execution
