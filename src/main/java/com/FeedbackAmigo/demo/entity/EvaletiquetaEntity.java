package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

public class EvaletiquetaEntity {

    @Entity
    @Table(name = "evaletiqueta")
    public class Evaletiqueta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "id_evaluacion", nullable = false)
        private Long idEvaluacion;

        @ManyToOne
        @JoinColumn(name = "id_etiqueta", nullable = false)
        private Etiqueta etiqueta;

        // getters y setters


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getIdEvaluacion() {
            return idEvaluacion;
        }

        public void setIdEvaluacion(Long idEvaluacion) {
            this.idEvaluacion = idEvaluacion;
        }

        /*public Etiqueta getEtiqueta() {
            return etiqueta;
        }

        public void setEtiqueta(Etiqueta etiqueta) {
            this.etiqueta = etiqueta;
        }*/
    }

}
