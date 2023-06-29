import express, {json} from 'express';
import {router as CoursesHttpController} from './api/CoursesHttpController';
import cors from 'cors';

const app = express();

app.use(cors());
app.use(json());
app.use('/api/v1/courses', CoursesHttpController);
app.listen(8081, ()=> console.log("Server has been started at 8081"));