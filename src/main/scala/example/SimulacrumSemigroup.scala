package example

import simulacrum._

@typeclass trait SimulacrumSemigroup[A] {
  @op("|*|") def append(x: A, y: A): A
}

/*
object SimulacrumSemigroup {
  def apply[A](
      implicit instance: SimulacrumSemigroup[A]): SimulacrumSemigroup[A] =
    instance

  trait Ops[A] {
    def typeClassInstance: SimulacrumSemigroup[A]
    def self: A
    def |*|(y: A): A = typeClassInstance.append(self, y)
  }

  trait ToSemigroupOps {
    implicit def toSemigroupOps[A](target: A)(
        implicit tc: SimulacrumSemigroup[A]): Ops[A] = new Ops[A] {
      val self = target
      val typeClassInstance = tc
    }
  }

  object nonInheritedOps extends ToSemigroupOps

  trait AllOps[A] extends Ops[A] {
    def typeClassInstance: SimulacrumSemigroup[A]
  }

  object ops {
    implicit def toAllSemigroupOps[A](target: A)(
        implicit tc: SimulacrumSemigroup[A]): AllOps[A] = new AllOps[A] {
      val self = target
      val typeClassInstance = tc
    }
  }
}
 */

object SimulacrumInstances {
  implicit val SimulacrumSemigroupInt: SimulacrumSemigroup[Int] =
    (left, right) => left + right
}
