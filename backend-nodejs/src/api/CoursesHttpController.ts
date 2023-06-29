import express from "express";
import {datasource as pool} from "../db/dbcp";


type Courses={

    "id":String,
    "describtion":String,
    "date":String
}


export const router = express.Router();


router.delete('/:id',  (req, res) => {
    console.log("hri");
    res.send("ok")
});

router.post('/',  (req, res) => {
    console.log("req");
    res.send("hri")
});
router.get('/',  async (req, res) => {
    const task = await pool.query('SELECT * FROM course');
    res.json(task);
});