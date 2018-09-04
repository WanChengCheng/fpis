import org.scalatest.{Matchers, WordSpecLike}
import exercises._

class Ch1 extends WordSpecLike with Matchers {
  "Chapter 1" when {
    "no exercise" should {
      "return 'Just Ignore' with its noExercise" in {
        {
          Ch1.noExercise
        } shouldBe "Just Ignore"
      }
    }
  }
}


