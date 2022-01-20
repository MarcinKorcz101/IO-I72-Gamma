import { Container, Row, Col } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';
import LevelSet from './LevelSet';

function BuildingSet() {
    const roomTemplate = {id:"", name:"", key: 0, area:"", cube:"", heating:"", light:""}
    const levelTemplate = {id:"", name:"", rooms:[roomTemplate], key:0};
    const [data, setData] = useState({id:"", name:"", levels:[levelTemplate]});


    function handleData(event, levelKey, roomKey){
        if(roomKey !== null){
            setData({...data, ['levels']:data.levels.map((level)=>
                                            (level.key === levelKey
                                                ?{...level,
                                                     ['rooms']:level.rooms.map((room)=>
                                                                (room.key === roomKey ? {...room, [event.target.name]: event.target.value}:room))}
                                                :level))})
        }else if(levelKey !== null){
            setData({...data, ['levels']:data.levels.map((level)=> (level.key === levelKey ? {...level, [event.target.name]:event.target.value}:level)) })
        }else{
            setData( {...data, [event.target.name]:event.target.value});
        }
    }


    function addLevel(){
        setData({...data, ['levels']:data.levels.concat({...levelTemplate, ['key']: data.levels.length})})
    }

    function deleteLevel(key){
        setData({...data, ['levels']:data.levels.filter((level)=>(level.key !== key)).map(
                                                    (level)=> (level.key > key ? {...level, ['key']:level.key-1}:level))})
    }

    function addRoom(key){
        setData({...data, ['levels']:data.levels.map((level)=>
                                            (level.key === key
                                                ?{...level, ['rooms']:level.rooms.concat({...roomTemplate, ['key']: level.rooms.length})} 
                                                :level))})
    }

    function deleteRoom(levelKey, roomKey){
        setData({...data, ['levels']:data.levels.map((level)=>
                                            (level.key === levelKey
                                                ?{...level, ['rooms']:level.rooms.filter((room) => (room.key !== roomKey)).map((room)=>(room.key > roomKey?{...room, ['key']:room.key-1}:room))} 
                                                :level))})
    }

    async function sendData(data) {
        try {
            const response = await axios.post(
            `http://localhost:8080/load`, data
            );
            console.log(response.data);
        } catch (error) {
        }

        
    }


    function handleSubmit(e){
        e.preventDefault();
        const dataWithoutKeys = {...data};
        for (const level of dataWithoutKeys.levels) {
            delete level.key
            for (const room of level.rooms) {
                delete room.key
              }
          }
          sendData(dataWithoutKeys);
        
          window.location.href = '/'
    }



  return (
    <Container className='building-container'>
        <form onSubmit={(e)=>(handleSubmit(e))}>
            <Container fluid className='building-name'>
                <Container><h3>Building:</h3></Container>
                <hr className='section-hr'/>
                <Container>
                    <Row>
                        <Col md={4}>
                            Name: <input required name="name" value={data.name} onChange={(e)=>(handleData(e, null, null))}/>
                        </Col>
                        <Col md={5}>
                             Id: <input required type='number' step={'1'} name="id" value={data.id} onChange={(e)=>(handleData(e, null, null))}/>
                        </Col>
                        <Col md={3} className='center'><div className='add-button' onClick={()=>addLevel()}>+ Add level</div></Col>
                    </Row>
                </Container>
            </Container>
            <hr/>
            {data.levels.map((level)=>
                <LevelSet key={level.key}
                        level={level}
                        addRoom={addRoom}
                        deleteLevel={deleteLevel} 
                        deleteRoom={deleteRoom}
                            handleData={handleData}
                            canDelete={data.levels.length > 1}/>
            )}
            <Container className='center'><input className='input-submit' type='submit' value="Set building"/></Container>
        </form>
    </Container>

    );
}   

export default BuildingSet;
