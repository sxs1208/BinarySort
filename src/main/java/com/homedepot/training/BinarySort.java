package com.homedepot.training;

public class BinarySort {


    public static void main(String[] args) {
        int data[] = {8, 7, 6, 12, 14, 18, 3};
        BinarySort app = new BinarySort();
        int foundIndex = app.performBinarySearch(data, 14);
    }

    public int  performBinarySearch(int[] data, int searchNumber) {

        DataNode dataNode = null;
        for(int i =0; i < data.length; i++) {
           dataNode = addNode(data[i], dataNode, i);
        }
        printInAsendingOrder(dataNode);

        findNode(searchNumber, dataNode);
        if(foundNode != null) {
            System.out.println("found: " + foundNode.data + " atIndex: " + foundNode.index);
        }
        else {
            System.out.println("Not found");
        }

        return foundNode.index;
    }

    DataNode foundNode;

    class DataNode {
        int data;
        int index;
        DataNode left;
        DataNode right;

        DataNode(int aData, int aIndex) {
            data = aData;
            left = null;
            right = null;
            index = aIndex;
        }
    }


    private DataNode addNode(int number, DataNode node, int aIndex) {

        if(node == null) {
            return new DataNode(number, aIndex);
        }
        if(node.data > number) {
            node.left = addNode(number, node.left, aIndex);
        } else if (node.data < number) {
                node.right = addNode(number, node.right, aIndex);
        }
        return node;
    }


    private void findNode(int number, DataNode dataNode) {
        if(dataNode != null) {
            if(dataNode.data == number) {
                foundNode = dataNode;
            }

            if(dataNode.data > number) {
                findNode(number, dataNode.left);
            }
            if(dataNode.data < number) {
                findNode(number, dataNode.right);
            }
        }
    }

    private void printInAsendingOrder(DataNode dataNode) {
        if(dataNode != null) {
            printInAsendingOrder(dataNode.left);
            System.out.println(dataNode.data);
            printInAsendingOrder(dataNode.right);
        }
    }

}
