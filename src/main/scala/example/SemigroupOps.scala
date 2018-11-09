package example

object SemigroupOps {
  implicit final def catsSyntaxSemigroup[A: Semigroup](a: A): SemigroupOps[A] =
    new SemigroupOps[A](a)
}

final class SemigroupOps[A: Semigroup](left: A) {
  def combine(right: A) = Semigroup[A].combine(left, right)
  def |+|(right: A) = Semigroup[A].combine(left, right)
}
