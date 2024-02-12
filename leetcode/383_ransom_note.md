# Analysis the logic
At the first I went a wrong way cause of misunderstanding the logic.
But after find answer I was frustrating, because the logic was easier than I though.

I did get the that meaning -> "if ransomNote can be constructed by using the letters from magazine".
The constructed means that I should simply check if the ransomNote letters consist in magazine or not.
But the english was not enough to understand question. 

# The Code
```javascript
/* conditions
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
var canConstuct = function(ransomNote, magazine){
    for(let r of ransomNote){
        if(!magazine.includes(r)) return false;
        
        /* replace the r with "" for remove the letter has checked.
         * this code helps perform the includes method to be faster.
         */
        magazine = magazine.replace(r,"");
    }
    
    return true;
}

```
