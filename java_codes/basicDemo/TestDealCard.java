package basicDemo;

/*
 * 实现扑克牌的分发，假设一副扑克牌52张(去掉大小王)
 * 实现随机洗牌操作给四个人分发手牌：每个人手牌数量是一定的
 * 最后将每个人分到的牌按照花色排序后输出
 */

import java.util.*;

public class TestDealCard {

	public static void main(String[] args) {
		int numOfHands = 4;
		int cardsPerHand = 12; //
		
		//生成一副牌
		String [] suit = {"♠","♣","❤","♦"};	// 
		String [] rank = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		List deck = new ArrayList();
		
		for(int i =0;i<suit.length;i++) {
			for (int j =0;j<rank.length;j++) {
				deck.add(suit[i]+rank[j]);
			}
		}
		
		Collections.shuffle(deck);	//随机改变 deck 中元素的排列次序，即洗牌
		
		for(int i=0;i<numOfHands;i++) {
		// 生成一手牌，并对牌按花色排序后输出
			List p = dealCard(deck,cardsPerHand);
			Collections.sort(p);
			System.out.println(p);
		}
	}
	
	public static List dealCard(List deck,int n) {
		int deckSize = deck.size();
		List handView = deck.subList(deckSize - n, deckSize); // 从 deck 中截取一个子列表
		
		// 利用该子链表创建一个链表，作为返回值
		List hand = new ArrayList(handView);
		handView.clear();
		return hand;
	}

}
