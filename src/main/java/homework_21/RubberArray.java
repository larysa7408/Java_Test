package homework_21;

public class RubberArray {
    private final double RESIZE_KOEF = 1.5;
    private final int INIT_DATA_SIZE = 10;
    private int[] data;
    private int length;

    public RubberArray() {
        data = new int[INIT_DATA_SIZE];
        length = 0;
    }

    public int size(){
        return length;
    }

    // Получение значения по индексу
    public int get(int idx) {
        return data[idx];
    }

    private void extendArrayIfNeed() {
        if (length == data.length) {
            // Создаем новый массив увеличенного размера на 1.5
            int[] newData = new int[(int) (data.length * RESIZE_KOEF)];
            // Переносим все элементы в новый массив
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            // Меняем ссылку на новый массив
            data = newData;
        }
    }

    // Добавление значения в конец массива
    public void add(int value) {
        extendArrayIfNeed();
        data[length] = value;
        length++;
    }

    // Добавление значения в указанную позицию массива
    public void add(int value, int idx) {
        extendArrayIfNeed();
        for (int i = length; i > idx; i--) {
            data[i] = data[i - 1];
        }
        data[idx] = value;
        length++;
    }

    // Удаление элемента по индексу
    public void remove(int idx) {
        // Смещаем элементы справа налево, начиная с индекса idx
        for (int i = idx; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
    }

    // Проверка наличия значения в массиве
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // Получение индекса значения в массиве
    public int indexOf(int value) {
        for (int i = 0; i < length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}