package com.compilerplugin

import scala.tools.nsc.Global
import scala.tools.nsc.Phase
import scala.tools.nsc.plugins._
import scala.tools.nsc.transform._

class CompilerPlugin(override val global: Global) extends Plugin {
  override val name = "compiler-plugin"
  override val description = "Compiler plugin"
  override val components = List(new CompilerPluginComponent(global))
}

class CompilerPluginComponent(val global: Global) 
  extends PluginComponent with TypingTransformers {
    import global._
    override val phaseName = "compiler-plugin-phase"
    override val runsAfter = List("parser")
    override def newPhase(prev: Phase) = new StdPhase(prev) {
      override def apply(unit: CompilationUnit) {
        unit.body = new MyTypingTransformer(unit).transform(unit.body)
      }
    }

    class MyTypingTransformer(unit: CompilationUnit) 
      extends TypingTransformer(unit) {
        def methodWrapper(rhs: Tree) = {
          Block(
            q"""println("Inside - before")""",
            DefDef(Modifiers(), TermName("runMethod"), List(), List(), TypeTree(), rhs),
            q"val r = runMethod",
            q"""println("Inside - after")""",
            q"r"
          )
        }

        override def transform(tree: Tree) = tree match {
          case dd: DefDef => 
            if (dd.mods.hasAnnotationNamed(
              TypeName(typeOf[annotations.wrapThisMethod].typeSymbol.name.toString))) {
              println(dd)
              val wrappedMethod = treeCopy.DefDef(dd, dd.mods, dd.name, dd.tparams, 
                dd.vparamss, dd.tpt, methodWrapper(dd.rhs))
              println(wrappedMethod)
              wrappedMethod
            } else {
              dd
            }
          case _ => super.transform(tree)
        }
    }
    
    def newTransformer(unit: CompilationUnit) = new MyTypingTransformer(unit)

    lazy val mirror: Mirror = {
      val rm = new GlobalMirror 
      rm.init
      rm.asInstanceOf[Mirror]
    }
    lazy val anno = mirror.getRequiredClass("wrapThisMethod")
}

