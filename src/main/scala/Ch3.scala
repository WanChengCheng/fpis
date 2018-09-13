package exercises

sealed trait List[+A] // `List` data type, parameterized on a type, `A`
case object Nil extends List[Nothing] // A `List` data constructor representing the empty list
/* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
which may be `Nil` or another `Cons`.
 */
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object Ch3 {
  // 3.2 tail,
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  // 3.2 setHead
  def setHead[A](l: List[A], x: A): List[A] = l match {
    case Nil => Nil
    case Cons(a, b) => Cons(x, b)
  }

  // 3.3 drop
  def drop[A](l: List[A], n: Int): List[A] = {
    @annotation.tailrec
    def loop(m: Int, remain: List[A]): List[A] = {
      if (m >= n) remain
      else remain match {
        case Nil => Nil
        case Cons(x, y) => loop(m + 1, y)
      }
    }

    loop(0, l)
  }

  // 3.4 dropWhile
  def dropWhile[A](l: List[A], condition: A => Boolean): List[A] = {
    l match {
      case Cons(x, y) if condition(x) => dropWhile(y, condition)
      case _ => l
    }
  }
}
