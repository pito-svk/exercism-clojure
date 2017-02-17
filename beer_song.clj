(ns beer-song)

(require '[clojure.string :as str])

(defn capitalize [text]
  (if (string? text)
    (str/capitalize text)
    text))

(defn bottle-num [n]
  (case n
    0 "no more"
    n))

(defn bottle-word [n]
  (case n
    1 "bottle"
    "bottles"))

(defn first-sentence [n]
  (str (capitalize (bottle-num n))
       " "
       (bottle-word n) 
       " of beer on the wall, "
       (bottle-num n)
       " "
       (bottle-word n)
       " of beer."))

(defn second-sentence [n]
  (case n
    0 "Go to the store and buy some more, 99 bottles of beer on the wall."
    1 "Take it down and pass it around, no more bottles of beer on the wall."
    (str "Take one down and pass it around, " (bottle-num (- n 1)) " " (bottle-word (- n 1)) " of beer on the wall.")))

(defn verse [n]
  (str (first-sentence n) "\n" (second-sentence n) "\n"))

(defn sing
  ([start] (sing start 0))
  ([start finish] (str/join "\n" (map verse (reverse (range finish (+ start 1)))))))
