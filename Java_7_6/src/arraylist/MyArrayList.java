
package arraylist;

import java.util.Arrays;

public class MyArrayList {

    public int[] elem;

    public int usedSize;

    private static final int DEFAULT_COUNT = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_COUNT];
    }

    // 打印顺序表,只需要打印到usedSize下标就可以了
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if (isFull()) {
            // 扩容, 使用Arrays.copyOf进行扩容
            this.elem = Arrays.copyOf(elem, 2 * this.elem.length);
        }

        this.elem[usedSize] = data;
        usedSize++;
    }

    /**
     * 判断这个顺序表是否满了
     *
     * @return 满了就返回true， 没满返回false
     */
    public boolean isFull() {
        if (usedSize == this.elem.length) {
            return true;
        } else {
            return false;
        }
    }

    // 头插,在数组最前面插入元素
    public void addHead(int data) {
        if (isFull()) {
            this.elem = Arrays.copyOf(elem, 2 * this.elem.length);
        }

        for (int i = usedSize; i > 0; i--) {

            this.elem[i] = this.elem[i - 1];
        }
        this.elem[0] = data;
        usedSize++;
    }

    /**
     * 在指定下标处插入数据
     *
     * @param pos  指定的下标
     * @param data 要插入的数据
     */
    public void addPos(int pos, int data) {
        if (isFull()) {
            this.elem = Arrays.copyOf(elem, 2 * this.elem.length);
        }

        //判断POS下标是否合法
        if (isLegalPos(pos)) {
            System.out.println(pos + "下标不合法");
        } else {
            if (pos == 0) {
                addHead(data);
            } else if (pos == usedSize) {
                add(data);
            } else {
                for (int i = usedSize; i > pos; i--) {
                    this.elem[i] = this.elem[i - 1];
                }
                this.elem[pos] = data;
                usedSize++;
            }
        }

    }

    /**
     * 判断POS下标处是否合法
     *
     * @param pos int类型下标
     * @return 合法返回false，不合法true
     */
    public boolean isLegalPos(int pos) {
        if (pos < 0 || pos > usedSize) {
            return true;
        }
        return false;
    }

    /**
     * 判断POS下标处是否合法
     *
     * @param pos int类型下标
     * @return 不合法返回抛出异常
     */
    public void checkPosLegal(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new PosIndexNotLegalException("pos位置不合法");
        }
    }

    /**
     * 判断数组中是否有指定元素
     *
     * @param data 所指定的元素
     * @return 如果有就返回true，没有就返回false
     */
    public boolean contains(int data) {
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == data) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断所指定元素的下标
     *
     * @param data 所指定的元素
     * @return 返回该元素的下标，没有就返回-1
     */
    public int indexOf(int data) {
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == data) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 得到POS下标的数据
     * @param pos pos下标
     * @return 返回的数据
     */
    public int getElemPosData(int pos) {
        checkPosLegal(pos);
        return this.elem[pos];
    }

    /**
     * 修改POS下标的数据
     * @param pos pos下标
     * @param data 要修改的数据
     */
    public void setElemPosData(int pos, int data) {
        checkPosLegal(pos);
        this.elem[pos] = data;
    }

    /**
     * 删除检测到的第一个数据
     * @param data 要删除的数据
     */
    public void remove(int data) {
        int ret = indexOf(data);
        if(ret == -1) {
            System.out.println("没有你要删除的数据");
        } else {
            for (int i = ret; i < usedSize; i++) {
                this.elem[i] = this.elem[i + 1];
            }
            usedSize--;
        }
    }

    // 获取该顺序表的有效数据的数量
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {
        /*
        for (int i = 0; i < usedSize; i++) {
            this.elem[i] = null;
        }
        */
        this.usedSize = 0;
    }
}
