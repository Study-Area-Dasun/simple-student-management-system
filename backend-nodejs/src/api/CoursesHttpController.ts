import express from "express";
import {datasource as pool} from "../db/dbcp";


type Courses={

    "id":string,
    "description":string,
    "duration":string
}


export const router = express.Router();


router.delete('/:id',  async (req, res) => {


});

router.post('/',  async (req, res) => {
    const course = (req.body as Courses);
    console.log(course)
    if (!course.id?.trim()){
        res.status(400).json("invalid id");
        return;
    }
   else  if (!course.description?.trim()) {
        res.status(400).json("invalid description");
        return;
    } else if(!course.duration?.trim()){
        res.status(400).json("invalid duration");
        return;
    }
   try {
       const result = await pool.query('INSERT INTO course (id,description,duration) VALUE (?,?,?)',
           [course.id,course.description,course.duration]);
       res.status(201).json(course);
   }catch (e) {
       res.status(400).json("This Id already save,Please try again!");
   }


});
router.get('/',  async (req, res) => {
    const task = await pool.query('SELECT * FROM course');
    res.json(task);
});