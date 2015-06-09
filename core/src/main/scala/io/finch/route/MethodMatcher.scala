package io.finch.route

import com.twitter.finagle.httpx.Method
import shapeless.HNil

/**
 * A [[Router]] that matches the given HTTP method.
 */
@deprecated("Use combinators instead", "0.8.0")
case class MethodMatcher(m: Method) extends Router[HNil] {
  def apply(input: RouterInput): Option[(RouterInput, HNil)] =
    if (input.request.method == m) Some((input, HNil)) else None
  override def toString = s"${m.toString.toUpperCase}"
}

//
// A group of routers that matches HTTP methods.
//
@deprecated("Use combinator \"get\" instead", "0.8.0")
object Get extends MethodMatcher(Method.Get)
@deprecated("Use combinator \"post\" instead", "0.8.0")
object Post extends MethodMatcher(Method.Post)
@deprecated("Use combinator \"patch\" instead", "0.8.0")
object Patch extends MethodMatcher(Method.Patch)
@deprecated("Use combinator \"delete\" instead", "0.8.0")
object Delete extends MethodMatcher(Method.Delete)
@deprecated("Use combinator \"head\" instead", "0.8.0")
object Head extends MethodMatcher(Method.Head)
@deprecated("Use combinator \"options\" instead", "0.8.0")
object Options extends MethodMatcher(Method.Options)
@deprecated("Use combinator \"put\" instead", "0.8.0")
object Put extends MethodMatcher(Method.Put)
@deprecated("Use combinator \"connect\" instead", "0.8.0")
object Connect extends MethodMatcher(Method.Connect)
@deprecated("Use combinator \"trace\" instead", "0.8.0")
object Trace extends MethodMatcher(Method.Trace)
