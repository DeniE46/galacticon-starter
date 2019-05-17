# galacticon-starter

A Simple tutorial application from RayWenderlich demonstrating the following Recycler View features:
  1. switching between LinearLayoutManager and GridLayoutManager
  2. itemTouchHelper to remove items with swipe gestures
  3. OnScrollListener for  getting the last position, compare it to the list size and fetch more data if the position and the list size match
  4. calling detail activity from within ViewHolder without interface eing implemented to the "parent" MainActivity
  5. Extension function to ease the inflation of the layout inside RecyclerAdapter in OnCreateViewHolder
