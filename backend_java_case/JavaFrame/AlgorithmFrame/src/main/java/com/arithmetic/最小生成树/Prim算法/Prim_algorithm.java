package com.arithmetic.最小生成树.Prim算法;

/**
 * 构造联通网的最小代价生成树成为最小生成树
 * 通过每次添加一个新节点加入集合,知道所有点加入停止的最小生成树的算法
 * 原理:每次连出该集合到其他所有点的最短边保证生成树的边权总和最小
 * 1.首先随便选一点加入集合
 * 2.用该点的所有边去刷新到其他点的最短路
 * 3.找出最短路中最短的一条连接(要求未访问过)
 * 4.用该点去刷新到其他店的最短路
 * 5重复以上操作n-1次
 * 6.最小生成树的代价就是连接的所有边的权值之和
 * 7.最适合用于稠密图的算法
 * @author yangzuliang
 *
 */
public class Prim_algorithm {

}
