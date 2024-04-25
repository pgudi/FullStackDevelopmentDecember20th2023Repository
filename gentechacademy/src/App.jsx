import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import HomePage from './pages/HomePage'
import AboutUs from './pages/AboutUs'
import ContactUs from './pages/ContactUs'
import CoursesPage from './pages/CoursesPage'
import LoginPage from './pages/LoginPage'
function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent></HeaderComponent>
        <Routes>
            <Route path='/' element={<LoginPage />} ></Route>
            <Route path="/home" element={<HomePage/>}></Route>
            <Route path="/about" element={<AboutUs/>}></Route>
            <Route path="/contact" element={<ContactUs/>}></Route>
            <Route path="/courses" element={<CoursesPage/>}></Route>
        </Routes>
        <FooterComponent></FooterComponent>
      </BrowserRouter>
    </>
  )
}

export default App
