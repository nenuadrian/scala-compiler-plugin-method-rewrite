# Scala Compiler Plugin: Annotation-Based Method AST Rewriting

This repository contains a Scala compiler plugin example that demonstrates basic annotation parsing, AST traversal, and method body replacement. It substitutes the block of a method (DefDef) with an inner method, allowing the original code to be wrapped and additional behavior injected.

https://medium.com/@adrian.n/scala-compiler-plugin-annotation-based-method-ast-rewriting-wrapping-substitution-b802f2d922f1


## Overview

This plugin showcases:
- Parsing annotations
- Traversing the Abstract Syntax Tree (AST)
- Replacing method bodies (DefDef)

The plugin rewrites annotated methods to include additional behaviour, such as logging or remote execution, without modifying the original method code.


