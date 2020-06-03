package _datastructure_demo;

/*
 * 栈(Stack)的定义：限制仅在表的一端进行插入和删除运算的线性表
 * (1)称提供插入、删除的这一端为栈顶(Top),另一端为栈底(Bottom)
 * (2)当表中没有元素时称为空栈
 * (3)栈为后进先出(LIFO)的线性表
 */
import java.util.LinkedList;

public class TestStack {
	LinkedList linkList = new LinkedList<Object>();
	// 判断栈是否空
	public boolean isEmpty() {
		return linkList.isEmpty();
	}
	// 获取栈大当前大小
	public int getSize() {
		return linkList.size();
	}
	// 清空栈
	public void clear() {
		linkList.clear();
	}
	// 入栈
	public void push(Object obj) {
		linkList.addFirst(obj);
	}
	// 移除并返回栈顶元素,即出栈方法
	public Object pop() {
		if(!linkList.isEmpty()) {
			return linkList.removeFirst();
		}
		return "当前栈为空";
	}
	public static void main(String[] args) {
		TestStack myStack = new TestStack();
		myStack.push(1);
		myStack.push(3);
		myStack.push(2);
		System.out.println("移除栈顶元素"+myStack.pop());	// 输出2
		System.out.println("移除栈顶元素"+myStack.pop());	// 输出3
	}
}
