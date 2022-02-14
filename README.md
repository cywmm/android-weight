# android-weight
> recycleview

SmoothScrollerLinearOffset 控制列表平滑滚动
- 参数offsetValue：设置滚动偏移量
- setScrollSpeed：设置滚动速度 `0 ~ X`
使用方法：
```kotlin
val smoothScroller = SmoothScrollerLinearOffset(this, R.dimen.xx, this)  //R.dimen.xx 偏移量

smoothScroller.setScrollSpeed(1.8f)  //设置滚动速度
smoothScroller.targetPosition = position  //滚动位置

recyclerView.layoutManager?.startSmoothScroll(smoothScroller)
```
