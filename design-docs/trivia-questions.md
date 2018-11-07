## trivia question ideas

### NLP-generated questions
1. which president had the highest/lowest reading level in their addresses?
  - can use Flesch-Kincaid analysis like in [this Guardian piece](https://www.theguardian.com/world/interactive/2013/feb/12/state-of-the-union-reading-level)
  - probably multiple choice


2. which president used the most/least words per sentence, on average, in their addresses?
  - this should be a simple counting task, probably best to use multiple choice


3. which president had the most positive/negative sentiment in their addresses, as assessed by [whatever] sentiment lexicon dictionary & algorithm?
 - not sure how much detail we want within the question about how the algorithm is counting sentiments
 - we would probably need to ask about the sentiments of the documents as a whole, which might not be particularly revealing or interesting
 - definitely need to normalize sentiment for document length


4. which of these words appears most in the corpus of addresses?
 - give a list of words, players pick which one they think appears most often across all documents


 5. which president used this word the most?
  - software provides a word (like "healthcare") and players choose which president they think used that word the most number of times in their addresses

  6. which president delivered more State of the Union addresses?
    - a basic count of who had more SOTUs, for example


7. Wordcloud attribution
  - players are given a wordcloud and a choice of presidents, and they guess which president's address matches the wordcloud
  - this might be a big challenge so maybe giving a choice of one president and matching their name to one of two or three wordclouds would be good


### Human-generated questions
1. match the presidential term
  - match a given president with the years of their presidential term(s) (this may or may not be an NLP-generated question)
 
