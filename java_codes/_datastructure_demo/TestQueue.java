package _datastructure_demo;

/*
 * 队列(Queue)定义：只允许在一端进行插入，而在另一端进行删除的运算受限的线性表
 * (1)允许删除的一端称之为队头(Front)
 * (2)允许插入的一端称之为队尾(Rear)
 * (3)没有元素的队列称之为空队列
 * (4)队列也叫先进先出(FIFO)的线性表
 */

import java.util.LinkedList;
	
public class TestQueue {
	LinkedList linkedList = new LinkedList();
	//判空
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	//获取当前队列长度
	public int getSize() {
		return linkedList.size();
	}
	//清空队列
	public void clear() {
		linkedList.clear();
	}
	// 队尾插入
	public void put(Object obj) {
		linkedList.addLast(obj);
	}
	// 队头移出元素
	public Object get() {
		if(!linkedList.isEmpty()) {
			return linkedList.removeFirst();
		}
		return "队列为空";
	}
	
	public static void main(String[] args) {
		TestQueue tq = new TestQueue();
		tq.put(100);
		tq.put(200);
		tq.put(300);
		System.out.println("队列是否为空"+tq.isEmpty());
		System.out.println("出队列操作"+tq.get());
		System.out.println("出队列操作"+tq.get());
		System.out.println("出队列操作"+tq.get());
		System.out.println("队列是否为空"+tq.isEmpty());
	}

}
