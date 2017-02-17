(ns bob)

(require '[clojure.string :as str])

(defn only-alpha [text]
  (apply str (filter #(Character/isLetter %) text))
)

(defn is-upper? [text]
  (and 
   (not (some #(Character/isLowerCase %) text)) 
   (some #(Character/isUpperCase %) text))
)

(defn nothing? [sentence]
  (empty? (str/trim sentence))
)

(defn yell? [sentence]
  (is-upper? sentence)
)

(defn question? [sentence]
  (= (last sentence) \?)
)

(defn response-for [sentence]
  (cond
    (nothing? sentence) "Fine. Be that way!"
    (yell? sentence) "Whoa, chill out!"
    (question? sentence) "Sure."
    :else "Whatever.")
)
