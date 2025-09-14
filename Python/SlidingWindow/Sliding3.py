def characterReplacement(s: str, k: int) -> int:
    count = {}
    res = 0
    l = 0
    maxFreq = 0  # To track the maximum frequency of any character in the window

    for r in range(len(s)):
        # Update the frequency of the current character
        count[s[r]] = count.get(s[r], 0) + 1
        maxFreq = max(maxFreq, count[s[r]])

        # Check if the current window is invalid
        while (r - l + 1) - maxFreq > k:
            count[s[l]] -= 1
            l += 1  # Shrink the window

        # Update the result with the size of the valid window
        res = max(res, r - l + 1)

    return res

# Test cases
if __name__ == "__main__":
    print(characterReplacement("AABABBA", 1))  # Expected: 4
    print(characterReplacement("ABAB", 2))     # Expected: 4
    print(characterReplacement("AAAB", 0))    # Expected: 3
