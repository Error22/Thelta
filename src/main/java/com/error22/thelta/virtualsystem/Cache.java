package com.error22.thelta.virtualsystem;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Cache {
	public int size;
	public byte[] data;
	public ByteBuffer buffer;

	public Cache(int size) {
		this.size = size;
		data = new byte[size];
		buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.BIG_ENDIAN);
	}
}