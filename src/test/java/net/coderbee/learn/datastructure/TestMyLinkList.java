package net.coderbee.learn.datastructure;

import org.junit.Assert;
import org.junit.Test;

public class TestMyLinkList {

    @Test
    public void testAppendTail() {
        MyLinkList<Integer> list = new MyLinkList<>();
        list.appendTail(1).appendTail(2).appendTail(3);
        System.out.println(list.toString());
        Assert.assertEquals("", "[1,2,3]", list.toString());
    }

    @Test
    public void testInsertHead() {
        MyLinkList<Integer> list = new MyLinkList<>();
        list.insertHead(1).insertHead(2).insertHead(3);
        System.out.println(list.toString());
        Assert.assertEquals("", "[3,2,1]", list.toString());
    }

    @Test
    public void testReserse() {
        MyLinkList<Integer> list = new MyLinkList<>();
        list.appendTail(1).appendTail(2).appendTail(3);
        list.reverse();
        System.out.println(list.toString());
        Assert.assertEquals("", "[3,2,1]", list.toString());
    }

    @Test
    public void testDeleteReserseN() {
        MyLinkList<Integer> list = new MyLinkList<>();
        list.appendTail(1).appendTail(2).appendTail(3).appendTail(4).appendTail(5);

        list.deleteReverseN(list.size());
        Assert.assertEquals("", "[2,3,4,5]", list.toString());

        list.deleteReverseN(2);
        Assert.assertEquals("", "[2,3,5]", list.toString());

        list.deleteReverseN(1);
        Assert.assertEquals("", "[2,3]", list.toString());
    }

    @Test
    public void testGetMiddle() {
        MyLinkList<Integer> list = new MyLinkList<>();
        Assert.assertNull(list.getMiddle());

        list.appendTail(1);
        Assert.assertEquals("", Integer.valueOf(1), list.getMiddle().val);

        list.appendTail(2);
        Assert.assertEquals("", Integer.valueOf(1), list.getMiddle().val);

        list.appendTail(3).appendTail(4).appendTail(5);
        Assert.assertEquals("", Integer.valueOf(3), list.getMiddle().val);
    }

}
