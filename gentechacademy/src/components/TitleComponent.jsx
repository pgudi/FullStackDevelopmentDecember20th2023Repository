import React from 'react'

const TitleComponent = (props) => {
  return (
    <div>
        <h1 className='text-center'>{props.name}</h1>
    </div>
  )
}

export default TitleComponent