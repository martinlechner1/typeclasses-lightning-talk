package example

trait Semigroup[A] {

  def combine(a: A, b: A): A

}

object Semigroup {

  implicit val SemigroupInt = new Semigroup[Int] {
    override def combine(a: Int, b: Int): Int = a + b
  }

  // 2.12 and above
  implicit val SemigroupString: Semigroup[String] =
    (left, right) => left + right

  def combine[A](a: A, b: A)(implicit s: Semigroup[A]): A = s.combine(a, b)

  def apply[A](implicit s: Semigroup[A]): Semigroup[A] = s

  def combine2[A: Semigroup](a: A, b: A): A = Semigroup[A].combine(a, b)

}
