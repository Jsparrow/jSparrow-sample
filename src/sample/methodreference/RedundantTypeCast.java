package sample.methodreference;

import java.util.concurrent.Future;

public class RedundantTypeCast {
	
	public void undefinedWildCardTypeArgument() {
		addUserListener((GenericFutureListener<Future<Person>>) res1 -> {
			res1.get().getBirthday();
			res1.isDone();
		});
		
		addUserListener((GenericFutureListener<Future<Person>>) (Future<Person> res1) -> {
			res1.get().getBirthday();
			res1.isDone();
		});
	}
	
	private void addUserListener(GenericFutureListener<? extends Future<? super Person>> listener) {
		
	}

}

interface GenericFutureListener<F extends Future<?>> {
    void operationComplete(F future) throws Exception;
}
