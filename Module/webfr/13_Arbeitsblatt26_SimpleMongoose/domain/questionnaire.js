"use strict";

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

/*
 * Define the database schema for entity 'Questionnaire'.
 * ATTENTION: Must be compatible to the Spring Mongo document.
 */
const questionnaireSchema = new Schema(
    {
        title: {
            type: String,
            min: 2,
            max: 30
        },
        description: {
            type: String,
            min: 10,
            max: 50
        }
    },
    {
        collection: 'questionnaires'
    }
);

/*
 * We need a field called 'id' to be compatible with Spring Mongo document.
 * Make it virtual so this field is not persisted.
 */
questionnaireSchema.virtual('id').get(function () {
    return this._id.toHexString();
});

/*
 * Activate the usage of virtual fields if toJSON method is called.
 */
questionnaireSchema.set('toJSON', {
    virtuals: true
});

module.exports = mongoose.model('Questionnaire', questionnaireSchema);
