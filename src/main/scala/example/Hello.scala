package example

import Semigroup._
import SemigroupOps._
import SimulacrumSemigroup.ops._
import SimulacrumInstances._

object Hello extends App {
  println(combine(1, 2))
  println(combine2(3, 4))
  println(5.combine(6))
  println(5 combine 6)
  println(7 |+| 8)
  println(9 |*| 10)
}
