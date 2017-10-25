package com.compilerplugin.annotations

import scala.annotation.StaticAnnotation

class annotation extends StaticAnnotation {}
object annotation {}


class wrapThisMethod extends annotation {}
object wrapThisMethod {}