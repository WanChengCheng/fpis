package fsis

class TypeConstructor {
}

object TypeConstructor {

}

trait Functor[F[_]] {
  def fmap[A, B](fa: F[A])(f: A => B): F[B]
}

trait FunctorLaws {
  def identity[F[_], A](fa: F[A])(implicit F: Functor[F]) = {
    F.fmap(fa)(a => a) == fa
  }

  def composition[F[_], A, B, C](fa: F[A], f: A => B, g: B => C)(implicit F: Functor[F]) = {
    F.fmap(F.fmap(fa)(f))(g) == F.fmap(fa)(f andThen g)
  }
}

object Functor {
  implicit val listFunctor: Functor[List] = new Functor[List] {
    def fmap[A, B](fa: List[A])(f: A => B): List[B] = {
      fa.map(f)
    }
  }

  implicit def functionAsFunctor[X]: Functor[X => ?] = new Functor[X => ?] {
    def fmap[A, B](fa: X => A)(f: A => B): X => B = {
      fa andThen f
    }
  }
}