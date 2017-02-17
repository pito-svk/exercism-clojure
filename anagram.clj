(ns anagram)

(require '[clojure.string :as str])

(defn sort-string [string]
  (apply str (sort string)))

(defn is-anagram? [word]
  (fn [item]
    (and 
     (= (sort-string (str/lower-case item)) 
        (sort-string (str/lower-case word)))
     (not= (str/lower-case word) (str/lower-case item)))))

(defn anagrams-for [word, collection]
  (filter (is-anagram? word) collection))
  
