(ns rna-transcription)

(defn nucleotide-to-rna [nucleotide]
  (case nucleotide 
    \C \G
    \G \C
    \A \U
    \T \A
    (assert false))
)

(defn to-rna [sequence]
  (apply str (map nucleotide-to-rna sequence))
)
