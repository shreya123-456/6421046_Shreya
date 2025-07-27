import React from 'react';
import './App.css';
import { books } from './data/books';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  return (
    <div>
      <div>
        <BookDetails books={books} />
        <BlogDetails />
        <CourseDetails />
      </div>
    </div>
  );
}

export default App;
