package practice;

public class SingletonPattern {
    // Classical Java implementation of singleton
// design pattern
    class Singleton
    {
        private static Singleton obj;

        // private constructor to force use of
        // getInstance() to create Singleton object
        private  Singleton() {}

        public Singleton getInstance()
        {
            if (obj==null)
                obj = new Singleton();
            return obj;
        }
    }

}
