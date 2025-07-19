import React from 'react'
import { Button } from 'semantic-ui-react'
import {
  CardMeta,
  CardHeader,
  CardDescription,
  CardContent,
  Card,
  Icon,
  Image,
} from 'semantic-ui-react'

const SCard = ({ id, title, pic, category, RemoveData }) => (
  <Card>
    <Image src={pic} wrapped ui={false} />
    <CardContent>
      <CardHeader>{id}</CardHeader>
      <CardDescription>{title}</CardDescription>
    </CardContent>

    <CardContent extra>
      <a>
        <Icon name='tag' />
        {category}
      </a>
    </CardContent>

    <div>
      <Button negative onClick={() => RemoveData(id)}>Remove</Button>
    </div>
  </Card>
)

export default SCard
