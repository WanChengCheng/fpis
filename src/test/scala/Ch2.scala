import org.scalatest.{Matchers, WordSpecLike}
import exercises._

class Ch2 extends WordSpecLike with Matchers {
  "Chapter 2" when {
    "def fib(n: Int): Int" should {
      "return the Fibonacci number of the given integer " which {
        "first element is 0" in {
          Ch2.fib(0) shouldBe 0
          Ch2.fibfor(0) shouldBe 0
          Ch2.fibrec(0) shouldBe 0
        }
        "second element is 1" in {
          Ch2.fib(1) shouldBe 1
          Ch2.fibfor(1) shouldBe 1
          Ch2.fibrec(1) shouldBe 1
        }
        "9th element should be 34" in {
          Ch2.fib(9) shouldBe 34
          Ch2.fibfor(9) shouldBe 34
          Ch2.fibrec(9) shouldBe 34
        }
      }
    }
  }
}
