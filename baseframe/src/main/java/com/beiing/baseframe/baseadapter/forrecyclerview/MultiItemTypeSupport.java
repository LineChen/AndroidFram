package com.beiing.baseframe.baseadapter.forrecyclerview;

public interface MultiItemTypeSupport<T> {
	int getLayoutId(int itemType);

	int getItemViewType(int position, T t);
}