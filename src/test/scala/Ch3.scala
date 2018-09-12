
import exercises._
import org.scalatest.{Matchers, WordSpecLike}

class Ch3 extends WordSpecLike with Matchers {
  "chapter 3" when {
    "tail" should {
      "return the tail of the List" in {
        Ch3.tail(Cons(1, Cons(2, Cons(3, Nil)))) shouldBe exercises.Cons(2, Cons(3, Nil))
      }
    }
    "setHead" should {
      "set the List with the given header" in {
        Ch3.setHead(Cons(1, Cons(2, Nil)), 2) shouldBe Cons(2, Cons(2, Nil))
      }
    }
    "drop" should {
      "remove the given element of the List" in {
        Ch3.drop(Cons(1, Cons(2, Cons(3, Cons(4, Nil)))), 2) shouldBe Cons(3, Cons(4, Nil))
      }
    }
  }
}
