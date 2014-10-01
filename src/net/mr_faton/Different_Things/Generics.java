package net.mr_faton.Different_Things;

/**
 * Created by root on 01.10.2014.
 */
public class Generics {
    public static void main(String[] args) {
        WithVersion<String> strV = new WithVersion<>("Mike", 10);
        WithVersion<int[]> intArrV = new WithVersion<>(new int[]{10, 20}, 5);
    }

    static class WithVersion<T> {
        private T value;
        private int version;

        WithVersion(T value, int version) {
            this.value = value;
            this.version = version;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }
}
