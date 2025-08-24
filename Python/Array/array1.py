import math
import heapq
from typing import List

class Array1:
    def pickGifts(self, g: List[int], k: int, debug: bool = False) -> int:
        # Create a max-heap (store negative values since Python has min-heap by default)
        max_heap = [-val for val in g]
        heapq.heapify(max_heap)

        if debug:
            print(f"Initial heap: {[-x for x in max_heap]}")

        # Perform k operations
        for step in range(1, k + 1):
            x = -heapq.heappop(max_heap)  # Extract largest
            new_val = int(math.sqrt(x))   # Replace with sqrt
            heapq.heappush(max_heap, -new_val)

            if debug:
                print(f"Step {step}: Took {x}, pushed {new_val}, heap now: {[-x for x in max_heap]}")

        # Return sum of all gifts left
        return sum(-val for val in max_heap)


# ---------------- TEST CASES ----------------
if __name__ == "__main__":
    solution = Array1()

    tests = [
        ([16, 25, 36, 49, 64], 3, 156),
        ([1, 1, 1, 1], 2, 4),
        ([100, 81, 64, 49, 36], 5, 39),
        ([100, 25, 64], 0, 189),
        ([1000], 2, 5),
    ]

    for i, (g, k, expected) in enumerate(tests, start=1):
        result = solution.pickGifts(g, k, debug=True if i == 1 else False)
        print(f"Test case {i}: Gifts={g}, k={k}")
        print(f"  ➝ Result = {result}, Expected = {expected}")
        print("-" * 40)
